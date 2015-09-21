/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Archivos;
import interfaces.ImagenInterface;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Docente
 */
public class ImagenDao implements ImagenInterface{

    @Override
    public boolean uploadImagen(Archivos a) {
        boolean op = false;
        Session s= HibernateUtil.getSessionFactory().getCurrentSession();
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
