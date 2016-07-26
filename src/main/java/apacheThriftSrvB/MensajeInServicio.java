/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package apacheThriftSrvB;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-06-17")
public class MensajeInServicio implements org.apache.thrift.TBase<MensajeInServicio, MensajeInServicio._Fields>, java.io.Serializable, Cloneable, Comparable<MensajeInServicio> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MensajeInServicio");

  private static final org.apache.thrift.protocol.TField CABECERA_FIELD_DESC = new org.apache.thrift.protocol.TField("cabecera", org.apache.thrift.protocol.TType.MAP, (short)1);
  private static final org.apache.thrift.protocol.TField CUERPO_FIELD_DESC = new org.apache.thrift.protocol.TField("cuerpo", org.apache.thrift.protocol.TType.MAP, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MensajeInServicioStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MensajeInServicioTupleSchemeFactory());
  }

  public Map<String,String> cabecera; // required
  public Map<String,String> cuerpo; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CABECERA((short)1, "cabecera"),
    CUERPO((short)2, "cuerpo");

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
        case 1: // CABECERA
          return CABECERA;
        case 2: // CUERPO
          return CUERPO;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CABECERA, new org.apache.thrift.meta_data.FieldMetaData("cabecera", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.MAP        , "TipoCabeceraIn")));
    tmpMap.put(_Fields.CUERPO, new org.apache.thrift.meta_data.FieldMetaData("cuerpo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.MAP        , "TipoCuerpoIn")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MensajeInServicio.class, metaDataMap);
  }

  public MensajeInServicio() {
  }

  public MensajeInServicio(
    Map<String,String> cabecera,
    Map<String,String> cuerpo)
  {
    this();
    this.cabecera = cabecera;
    this.cuerpo = cuerpo;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MensajeInServicio(MensajeInServicio other) {
    if (other.isSetCabecera()) {
      this.cabecera = other.cabecera;
    }
    if (other.isSetCuerpo()) {
      this.cuerpo = other.cuerpo;
    }
  }

  public MensajeInServicio deepCopy() {
    return new MensajeInServicio(this);
  }

  @Override
  public void clear() {
    this.cabecera = null;
    this.cuerpo = null;
  }

  public int getCabeceraSize() {
    return (this.cabecera == null) ? 0 : this.cabecera.size();
  }

  public void putToCabecera(String key, String val) {
    if (this.cabecera == null) {
      this.cabecera = new HashMap<String,String>();
    }
    this.cabecera.put(key, val);
  }

  public Map<String,String> getCabecera() {
    return this.cabecera;
  }

  public MensajeInServicio setCabecera(Map<String,String> cabecera) {
    this.cabecera = cabecera;
    return this;
  }

  public void unsetCabecera() {
    this.cabecera = null;
  }

  /** Returns true if field cabecera is set (has been assigned a value) and false otherwise */
  public boolean isSetCabecera() {
    return this.cabecera != null;
  }

  public void setCabeceraIsSet(boolean value) {
    if (!value) {
      this.cabecera = null;
    }
  }

  public int getCuerpoSize() {
    return (this.cuerpo == null) ? 0 : this.cuerpo.size();
  }

  public void putToCuerpo(String key, String val) {
    if (this.cuerpo == null) {
      this.cuerpo = new HashMap<String,String>();
    }
    this.cuerpo.put(key, val);
  }

  public Map<String,String> getCuerpo() {
    return this.cuerpo;
  }

  public MensajeInServicio setCuerpo(Map<String,String> cuerpo) {
    this.cuerpo = cuerpo;
    return this;
  }

  public void unsetCuerpo() {
    this.cuerpo = null;
  }

  /** Returns true if field cuerpo is set (has been assigned a value) and false otherwise */
  public boolean isSetCuerpo() {
    return this.cuerpo != null;
  }

  public void setCuerpoIsSet(boolean value) {
    if (!value) {
      this.cuerpo = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CABECERA:
      if (value == null) {
        unsetCabecera();
      } else {
        setCabecera((Map<String,String>)value);
      }
      break;

    case CUERPO:
      if (value == null) {
        unsetCuerpo();
      } else {
        setCuerpo((Map<String,String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CABECERA:
      return getCabecera();

    case CUERPO:
      return getCuerpo();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CABECERA:
      return isSetCabecera();
    case CUERPO:
      return isSetCuerpo();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MensajeInServicio)
      return this.equals((MensajeInServicio)that);
    return false;
  }

  public boolean equals(MensajeInServicio that) {
    if (that == null)
      return false;

    boolean this_present_cabecera = true && this.isSetCabecera();
    boolean that_present_cabecera = true && that.isSetCabecera();
    if (this_present_cabecera || that_present_cabecera) {
      if (!(this_present_cabecera && that_present_cabecera))
        return false;
      if (!this.cabecera.equals(that.cabecera))
        return false;
    }

    boolean this_present_cuerpo = true && this.isSetCuerpo();
    boolean that_present_cuerpo = true && that.isSetCuerpo();
    if (this_present_cuerpo || that_present_cuerpo) {
      if (!(this_present_cuerpo && that_present_cuerpo))
        return false;
      if (!this.cuerpo.equals(that.cuerpo))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_cabecera = true && (isSetCabecera());
    list.add(present_cabecera);
    if (present_cabecera)
      list.add(cabecera);

    boolean present_cuerpo = true && (isSetCuerpo());
    list.add(present_cuerpo);
    if (present_cuerpo)
      list.add(cuerpo);

    return list.hashCode();
  }

  @Override
  public int compareTo(MensajeInServicio other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCabecera()).compareTo(other.isSetCabecera());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCabecera()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cabecera, other.cabecera);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCuerpo()).compareTo(other.isSetCuerpo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCuerpo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cuerpo, other.cuerpo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MensajeInServicio(");
    boolean first = true;

    sb.append("cabecera:");
    if (this.cabecera == null) {
      sb.append("null");
    } else {
      sb.append(this.cabecera);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("cuerpo:");
    if (this.cuerpo == null) {
      sb.append("null");
    } else {
      sb.append(this.cuerpo);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MensajeInServicioStandardSchemeFactory implements SchemeFactory {
    public MensajeInServicioStandardScheme getScheme() {
      return new MensajeInServicioStandardScheme();
    }
  }

  private static class MensajeInServicioStandardScheme extends StandardScheme<MensajeInServicio> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MensajeInServicio struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CABECERA
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                struct.cabecera = new HashMap<String,String>(2*_map0.size);
                String _key1;
                String _val2;
                for (int _i3 = 0; _i3 < _map0.size; ++_i3)
                {
                  _key1 = iprot.readString();
                  _val2 = iprot.readString();
                  struct.cabecera.put(_key1, _val2);
                }
                iprot.readMapEnd();
              }
              struct.setCabeceraIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CUERPO
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map4 = iprot.readMapBegin();
                struct.cuerpo = new HashMap<String,String>(2*_map4.size);
                String _key5;
                String _val6;
                for (int _i7 = 0; _i7 < _map4.size; ++_i7)
                {
                  _key5 = iprot.readString();
                  _val6 = iprot.readString();
                  struct.cuerpo.put(_key5, _val6);
                }
                iprot.readMapEnd();
              }
              struct.setCuerpoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, MensajeInServicio struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.cabecera != null) {
        oprot.writeFieldBegin(CABECERA_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.cabecera.size()));
          for (Map.Entry<String, String> _iter8 : struct.cabecera.entrySet())
          {
            oprot.writeString(_iter8.getKey());
            oprot.writeString(_iter8.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.cuerpo != null) {
        oprot.writeFieldBegin(CUERPO_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.cuerpo.size()));
          for (Map.Entry<String, String> _iter9 : struct.cuerpo.entrySet())
          {
            oprot.writeString(_iter9.getKey());
            oprot.writeString(_iter9.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MensajeInServicioTupleSchemeFactory implements SchemeFactory {
    public MensajeInServicioTupleScheme getScheme() {
      return new MensajeInServicioTupleScheme();
    }
  }

  private static class MensajeInServicioTupleScheme extends TupleScheme<MensajeInServicio> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MensajeInServicio struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCabecera()) {
        optionals.set(0);
      }
      if (struct.isSetCuerpo()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetCabecera()) {
        {
          oprot.writeI32(struct.cabecera.size());
          for (Map.Entry<String, String> _iter10 : struct.cabecera.entrySet())
          {
            oprot.writeString(_iter10.getKey());
            oprot.writeString(_iter10.getValue());
          }
        }
      }
      if (struct.isSetCuerpo()) {
        {
          oprot.writeI32(struct.cuerpo.size());
          for (Map.Entry<String, String> _iter11 : struct.cuerpo.entrySet())
          {
            oprot.writeString(_iter11.getKey());
            oprot.writeString(_iter11.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MensajeInServicio struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TMap _map12 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.cabecera = new HashMap<String,String>(2*_map12.size);
          String _key13;
          String _val14;
          for (int _i15 = 0; _i15 < _map12.size; ++_i15)
          {
            _key13 = iprot.readString();
            _val14 = iprot.readString();
            struct.cabecera.put(_key13, _val14);
          }
        }
        struct.setCabeceraIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TMap _map16 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.cuerpo = new HashMap<String,String>(2*_map16.size);
          String _key17;
          String _val18;
          for (int _i19 = 0; _i19 < _map16.size; ++_i19)
          {
            _key17 = iprot.readString();
            _val18 = iprot.readString();
            struct.cuerpo.put(_key17, _val18);
          }
        }
        struct.setCuerpoIsSet(true);
      }
    }
  }

}

