package org.omg.Dynamic;


/**
* org/omg/Dynamic/Parameter.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../../src/share/classes/org/omg/PortableInterceptor/Interceptors.idl
* Friday, June 21, 2013 12:53:42 PM PDT
*/

public final class Parameter implements org.omg.CORBA.portable.IDLEntity
{
  public org.omg.CORBA.Any argument = null;
  public org.omg.CORBA.ParameterMode mode = null;

  public Parameter ()
  {
  } // ctor

  public Parameter (org.omg.CORBA.Any _argument, org.omg.CORBA.ParameterMode _mode)
  {
    argument = _argument;
    mode = _mode;
  } // ctor

} // class Parameter
