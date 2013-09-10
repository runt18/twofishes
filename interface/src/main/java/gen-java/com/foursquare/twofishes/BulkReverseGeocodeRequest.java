/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.foursquare.twofishes;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

// No additional import required for struct/union.

public class BulkReverseGeocodeRequest implements TBase<BulkReverseGeocodeRequest, BulkReverseGeocodeRequest._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("BulkReverseGeocodeRequest");

  private static final TField LATLNGS_FIELD_DESC = new TField("latlngs", TType.LIST, (short)1);
  private static final TField PARAMS_FIELD_DESC = new TField("params", TType.STRUCT, (short)2);

  public List<GeocodePoint> latlngs;
  public CommonGeocodeRequestParams params;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    LATLNGS((short)1, "latlngs"),
    PARAMS((short)2, "params");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // LATLNGS
          return LATLNGS;
        case 2: // PARAMS
          return PARAMS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.LATLNGS, new FieldMetaData("latlngs", TFieldRequirementType.OPTIONAL, 
        new ListMetaData(TType.LIST, 
            new StructMetaData(TType.STRUCT, GeocodePoint.class))));
    tmpMap.put(_Fields.PARAMS, new FieldMetaData("params", TFieldRequirementType.OPTIONAL, 
        new StructMetaData(TType.STRUCT, CommonGeocodeRequestParams.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(BulkReverseGeocodeRequest.class, metaDataMap);
  }

  public BulkReverseGeocodeRequest() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BulkReverseGeocodeRequest(BulkReverseGeocodeRequest other) {
    if (other.isSetLatlngs()) {
      List<GeocodePoint> __this__latlngs = new ArrayList<GeocodePoint>();
      for (GeocodePoint other_element : other.latlngs) {
        __this__latlngs.add(new GeocodePoint(other_element));
      }
      this.latlngs = __this__latlngs;
    }
    if (other.isSetParams()) {
      this.params = new CommonGeocodeRequestParams(other.params);
    }
  }

  public BulkReverseGeocodeRequest deepCopy() {
    return new BulkReverseGeocodeRequest(this);
  }

  @Override
  public void clear() {
    this.latlngs = null;
    this.params = null;
  }

  public int getLatlngsSize() {
    return (this.latlngs == null) ? 0 : this.latlngs.size();
  }

  public java.util.Iterator<GeocodePoint> getLatlngsIterator() {
    return (this.latlngs == null) ? null : this.latlngs.iterator();
  }

  public void addToLatlngs(GeocodePoint elem) {
    if (this.latlngs == null) {
      this.latlngs = new ArrayList<GeocodePoint>();
    }
    this.latlngs.add(elem);
  }

  public List<GeocodePoint> getLatlngs() {
    return this.latlngs;
  }

  public BulkReverseGeocodeRequest setLatlngs(List<GeocodePoint> latlngs) {
    this.latlngs = latlngs;
    return this;
  }

  public void unsetLatlngs() {
    this.latlngs = null;
  }

  /** Returns true if field latlngs is set (has been asigned a value) and false otherwise */
  public boolean isSetLatlngs() {
    return this.latlngs != null;
  }

  public void setLatlngsIsSet(boolean value) {
    if (!value) {
      this.latlngs = null;
    }
  }

  public CommonGeocodeRequestParams getParams() {
    return this.params;
  }

  public BulkReverseGeocodeRequest setParams(CommonGeocodeRequestParams params) {
    this.params = params;
    return this;
  }

  public void unsetParams() {
    this.params = null;
  }

  /** Returns true if field params is set (has been asigned a value) and false otherwise */
  public boolean isSetParams() {
    return this.params != null;
  }

  public void setParamsIsSet(boolean value) {
    if (!value) {
      this.params = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case LATLNGS:
      if (value == null) {
        unsetLatlngs();
      } else {
        setLatlngs((List<GeocodePoint>)value);
      }
      break;

    case PARAMS:
      if (value == null) {
        unsetParams();
      } else {
        setParams((CommonGeocodeRequestParams)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case LATLNGS:
      return getLatlngs();

    case PARAMS:
      return getParams();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case LATLNGS:
      return isSetLatlngs();
    case PARAMS:
      return isSetParams();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BulkReverseGeocodeRequest)
      return this.equals((BulkReverseGeocodeRequest)that);
    return false;
  }

  public boolean equals(BulkReverseGeocodeRequest that) {
    if (that == null)
      return false;

    boolean this_present_latlngs = true && this.isSetLatlngs();
    boolean that_present_latlngs = true && that.isSetLatlngs();
    if (this_present_latlngs || that_present_latlngs) {
      if (!(this_present_latlngs && that_present_latlngs))
        return false;
      if (!this.latlngs.equals(that.latlngs))
        return false;
    }

    boolean this_present_params = true && this.isSetParams();
    boolean that_present_params = true && that.isSetParams();
    if (this_present_params || that_present_params) {
      if (!(this_present_params && that_present_params))
        return false;
      if (!this.params.equals(that.params))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(BulkReverseGeocodeRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    BulkReverseGeocodeRequest typedOther = (BulkReverseGeocodeRequest)other;

    lastComparison = Boolean.valueOf(isSetLatlngs()).compareTo(typedOther.isSetLatlngs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLatlngs()) {
      lastComparison = TBaseHelper.compareTo(this.latlngs, typedOther.latlngs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetParams()).compareTo(typedOther.isSetParams());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParams()) {
      lastComparison = TBaseHelper.compareTo(this.params, typedOther.params);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // LATLNGS
          if (field.type == TType.LIST) {
            {
              TList _list80 = iprot.readListBegin();
              this.latlngs = new ArrayList<GeocodePoint>(_list80.size);
              for (int _i81 = 0; _i81 < _list80.size; ++_i81)
              {
                GeocodePoint _elem82;
                _elem82 = new GeocodePoint();
                _elem82.read(iprot);
                this.latlngs.add(_elem82);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // PARAMS
          if (field.type == TType.STRUCT) {
            this.params = new CommonGeocodeRequestParams();
            this.params.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.latlngs != null) {
      if (isSetLatlngs()) {
        oprot.writeFieldBegin(LATLNGS_FIELD_DESC);
        {
          oprot.writeListBegin(new TList(TType.STRUCT, this.latlngs.size()));
          for (GeocodePoint _iter83 : this.latlngs)
          {
            _iter83.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.params != null) {
      if (isSetParams()) {
        oprot.writeFieldBegin(PARAMS_FIELD_DESC);
        this.params.write(oprot);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BulkReverseGeocodeRequest(");
    boolean first = true;

    if (isSetLatlngs()) {
      sb.append("latlngs:");
      if (this.latlngs == null) {
        sb.append("null");
      } else {
        sb.append(this.latlngs);
      }
      first = false;
    }
    if (isSetParams()) {
      if (!first) sb.append(", ");
      sb.append("params:");
      if (this.params == null) {
        sb.append("null");
      } else {
        sb.append(this.params);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}
