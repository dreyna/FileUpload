/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;


/**
 *
 * @author Docente
 */
@ManagedBean
@RequestScoped
public class UploadBeans implements Serializable{

    private final String ruta = "C:\\tmp\\";
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
  
private void subirarchivo(String filename, InputStream in){
    try {
        OutputStream os = new FileOutputStream(new File(ruta + filename));
        int reader = 0;
        //byte[] bytes;
        //bytes = new byte[(int)getFile().getSize()];
        byte[] bytes = new byte[(int) getFile().getSize()];
        while((reader = in.read(bytes)) != -1){
          os.write(bytes, 0, reader);
        }
        in.close();
        os.flush();
        os.close();
    } catch (Exception e) {
    }

}
public void upload(){
        
        String extValidate;

        if (getFile()!= null) {
            String ext = getFile().getFileName();

            if (ext != null) {
                extValidate = ext.substring(ext.indexOf(".") + 1);
            } else {
                extValidate = "null";
            }

            if (extValidate.equals("jpg")) {
                try {
                    subirarchivo(getFile().getFileName(), getFile().getInputstream());
                } catch (IOException e) {
                    Logger.getLogger(UploadBeans.class.getName()).log(Level.SEVERE, null, e);
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Error", "Um problema ocorreu ao enviar o arquivo!"));
                }

                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Sucesso", getFile().getFileName() + "O envio do arquivo foi bem sucedido!"));
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Error", "Extensão de arquivo não permitida!"));
            }
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro", "Nenhum arquivo foi selecionado!"));
        }
    }
    
}
