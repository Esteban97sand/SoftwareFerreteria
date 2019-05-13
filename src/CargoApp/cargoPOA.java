package CargoApp;


/**
* CargoApp/cargoPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Cargo.idl
* lunes 13 de mayo de 2019 02:04:11 PM COT
*/

public abstract class cargoPOA extends org.omg.PortableServer.Servant
 implements CargoApp.cargoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("insertarCargo", new java.lang.Integer (0));
    _methods.put ("actualizarCargo", new java.lang.Integer (1));
    _methods.put ("eliminarCargo", new java.lang.Integer (2));
    _methods.put ("shoutdown", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CargoApp/cargo/insertarCargo
       {
         String codigo = in.read_wstring ();
         String nombre = in.read_wstring ();
         int sueldo = in.read_long ();
         boolean $result = false;
         $result = this.insertarCargo (codigo, nombre, sueldo);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // CargoApp/cargo/actualizarCargo
       {
         int idCargo = in.read_long ();
         String codigo = in.read_wstring ();
         String nombre = in.read_wstring ();
         int sueldo = in.read_long ();
         boolean $result = false;
         $result = this.actualizarCargo (idCargo, codigo, nombre, sueldo);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // CargoApp/cargo/eliminarCargo
       {
         int idCargo = in.read_long ();
         boolean $result = false;
         $result = this.eliminarCargo (idCargo);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // CargoApp/cargo/shoutdown
       {
         this.shoutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CargoApp/cargo:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public cargo _this() 
  {
    return cargoHelper.narrow(
    super._this_object());
  }

  public cargo _this(org.omg.CORBA.ORB orb) 
  {
    return cargoHelper.narrow(
    super._this_object(orb));
  }


} // class cargoPOA
