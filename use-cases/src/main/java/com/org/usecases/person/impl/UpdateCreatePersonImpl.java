
package com.org.usecases.person.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.ContratDao;
import com.org.model.PersonModel;
import com.org.usecases.UpdateCreate;

/**
 * A Renseigner.
 * @author  : admin
 * @project : use-cases
 * @package : com.org.usecases.impl
 * @date    : 20 sept. 2016 22:57:12
 */
@Service("updateCreatePerson")
public class UpdateCreatePersonImpl implements UpdateCreate<PersonModel>
{
   private static final Logger              logger = LoggerFactory.getLogger( UpdateCreatePersonImpl.class );
   
   @Autowired
   private ContratDao<PersonModel, Integer> personDao;
   
   /**
    * 
    * @see com.org.usecases.UpdateCreate#update(java.lang.Object)
    */
   @Override
   public PersonModel update( PersonModel t )
   {
      logger.info( "update" );
      return personDao.update( t );
   }
   
   /**
   * 
   * @see com.org.usecases.UpdateCreate#create(java.lang.Object)
   */
   @Override
   public PersonModel create( PersonModel t )
   {
      logger.info( "create" );
      return personDao.create( t );
   }
}
