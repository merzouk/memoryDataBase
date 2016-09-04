/**
 * 
 */

package com.org.utils;

import java.util.Comparator;

import com.org.model.PersonModel;

/**
 * 
 * This class compares the contents of two object type PersonModel
 * 
 * @author  : mmenhour
 * @project : persist
 * @package : com.org.utils
 * @date    : 4 sept. 2016 14:18:01
 */
public class DefaultOrder implements Comparator<PersonModel>
{
   
   public DefaultOrder()
   {
      // Do nothing
   }
   
   /**
    * @param o1 the first object to be compared.
    * @param o2 the second object to be compared.
    * 
    * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater
    *         than the second.
    */
   public int compare( PersonModel o1, PersonModel o2 )
   {
      if( o1 == null )
      {
         return o2 == null ? 0 : -1;
      }
      if( o2 == null )
      {
         return 1;
      }
      
      Integer id1 = o1.getId();
      Integer id2 = o2.getId();
      if( id1 != null && id2 != null )
      {
         if( id1 != id2 )
         {
            return id1 - id2;
         }
         else
         {
            Integer pk1 = o1.getId();
            Integer pk2 = o2.getId();
            return pk1 - pk2;
         }
      }
      String email1 = o1.getEmail();
      String email2 = o2.getEmail();
      if( email1 != null && email1 != null )
      {
         if( !email1.equals( email2 ) )
         {
            return email1.compareTo( email2 );
         }
      }
      if( id1 == null )
      {
         return 1;
      }
      return -1;
   }
}
