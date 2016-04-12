#!/usr/bin/python

import os
import sys
import locale
from optparse import OptionParser

usage = "usage: %prog [options] hfile_directory"
parser = OptionParser(usage = usage)
parser.add_option("--host", dest="host",  default="0.0.0.0", type='string',
  help="host")
parser.add_option("-p", "--port", dest="port",  default=8080, type='int',
  help="port")
parser.add_option("--warmup", dest="warmup",  default=False, action='store_true',
  help="warmup service, increases startup time")
parser.add_option("--preload", dest="preload",  default=False, action='store_true',
  help="preload index to prevent coldstart, increases startup time")
parser.add_option("--nopreload", dest="preload",  default=False, action='store_false',
  help="don't preload index to prevent coldstart, decrease startup time, increases intial latency")
parser.add_option("-r", "--rebel", dest="rebel",  default=False, action='store_true',
  help="rebel")
parser.add_option("-c", "--console", dest="console",  default=False, action='store_true',
  help="console, not server")
parser.add_option("--hotfix_basepath", dest="hotfix", default="", type='string',
  help="path to hotfixes")
parser.add_option("--enable_private_endpoints", dest="enablePrivate", default=False, action='store_true',
  help="enable private endpoints on server")


(options, args) = parser.parse_args()

if len(args) != 1:
  parser.print_usage()
  sys.exit(1)

if (locale.getdefaultlocale()[1] != 'UTF-8' and
    locale.getdefaultlocale()[1] != 'UTF8'):
  print "locale is not UTF-8, unsure if this will work"
  print "see: http://perlgeek.de/en/article/set-up-a-clean-utf8-environment for details"
  sys.exit(1)

basepath = os.path.abspath(args[0])

sbt = './sbt'
if options.rebel:
  sbt = './sbt-rebel'

args = ' --preload {0!s} --warmup {1!s} --enable_private_endpoints {2!s} '.format(options.preload, options.warmup, options.enablePrivate)
if (len(options.hotfix) > 0):
  args += '--hotfix_basepath {0!s} '.format(options.hotfix)

if options.console:
  target = 'console'
else:
  target = 'run-main'

cmd = '{0!s} "server/{1!s} com.foursquare.twofishes.GeocodeFinagleServer {2!s} --host {3!s} --port {4:d} --hfile_basepath {5!s}"'.format(sbt, target, args, options.host, options.port, basepath)

print(cmd)
os.system(cmd)

