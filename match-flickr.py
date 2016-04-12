#!/usr/bin/python
import sys
import csv
import urllib
import urllib2
import json
import geojson

output = {}

files = sys.argv[1:]
for f in files:
  fdata = open(f).read()
  try:
    data = geojson.loads(fdata)
  except:
    print url
    print 'failed to parse: ' + fdata
    continue
  for feature in data['features']:
    woeid = str(feature['properties']['woe_id'])
    label = feature['properties']['label']
    woetype = int(feature['properties']['place_type_id'])
    bbox = feature['geometry']['bbox']

    url = u"http://dev-blackmad:8081/?query={0!s}&woeHint={1!s}".format(urllib.quote(label.encode('utf-8')), woetype)
    try:
      response = urllib2.urlopen(url)
      data = response.read()
    except:
      print url
      print "Unexpected error:", sys.exc_info()[0]
      continue

    jsonData = json.loads(data)

    geocodes = False
    match = False

    for interp in jsonData['interpretations']:
      if interp['what']:
        break

      fwoetype = interp['feature']['woeType']
      geocodes = True

      center = interp['feature']['geometry']['center']

      if (
        center['lat'] >= bbox[1] and 
        center['lat'] <= bbox[3] and 
        center['lng'] >= bbox[0] and 
        center['lng'] <= bbox[2]
      ):
        match = True
        geonameids = filter(lambda i: i['source'] == 'geonameid', interp['feature']['ids'])
        if len(geonameids):
          id = geonameids[0]['id']
          if ((id not in output) or (output[id][0] == False)):
            lowlng = bbox[0]
            lowlat = bbox[1]
            hilng = bbox[2]
            hilat = bbox[3]
            output[id] = (fwoetype == woetype, '{0!s}\t{1!s}\t{2!s}\t{3!s}\t{4!s}'.format(id, lowlng, lowlat, hilng, hilat))

    if not geocodes:
      print (u'No geocodes for {0!s} {1!s}'.format(woeid, label)).encode('utf-8')
    elif not match:
      print (u'Geocodes, but no match for {0!s}: {1!s}'.format(woeid, label)).encode('utf-8')
      print bbox
      print '\t' + url

outfile = open('flickr-bbox.tsv', 'w')
for k in output:
  outfile.write('{0!s}\n'.format(output[k][1]))


