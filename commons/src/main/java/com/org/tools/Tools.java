package com.org.tools;

/**
 * A Renseigner.
 * @author  : admin
 * @project : commons
 * @package : com.org.unit
 * @date    : 21 sept. 2016 20:15:09
 */
public class Tools
{
   
   /**
    * 
    * @param email
    * @return
    */
   public static boolean isValidEmailAddress( String email )
   {
      String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
      java.util.regex.Pattern p = java.util.regex.Pattern.compile( ePattern );
      java.util.regex.Matcher m = p.matcher( email );
      return m.matches();
   }
}
