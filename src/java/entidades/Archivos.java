package entidades;
// Generated 20/09/2015 09:17:58 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Archivos generated by hbm2java
 */
@Entity
@Table(name="archivos"
    ,catalog="bd_archivos"
)
public class Archivos  implements java.io.Serializable {


     private Integer idarchivos;
     private String nombre;
     private String ruta;

    public Archivos() {
    }

    public Archivos(String nombre, String ruta) {
       this.nombre = nombre;
       this.ruta = ruta;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idarchivos", unique=true, nullable=false)
    public Integer getIdarchivos() {
        return this.idarchivos;
    }
    
    public void setIdarchivos(Integer idarchivos) {
        this.idarchivos = idarchivos;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="ruta", nullable=false, length=200)
    public String getRuta() {
        return this.ruta;
    }
    
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }




}

