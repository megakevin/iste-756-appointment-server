/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

/**
 *
 * @author Kevin
 */
public class ServiceModel {
    private String intro;
    private String wadl;
    
    public ServiceModel() {}
    
    public ServiceModel(String intro, String wadl) 
    {
        this.intro = intro;
        this.wadl = wadl;
    }

    public String getIntro() {
        return this.intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getWadl() {
        return this.wadl;
    }
    public void setWadl(String wadl) {
        this.wadl = wadl;
    }


    
    
    

}
