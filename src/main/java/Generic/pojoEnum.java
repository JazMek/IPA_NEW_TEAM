package Generic;

public enum pojoEnum {

    AddPlace("/maps/api/place/add/json"),
    DeletePlace("/maps/api/place/delete/json"),
    GetPlace("/maps/api/place/get/json");
    private  String resource;
    pojoEnum(String resource){
        this.resource = resource;
    }
   public  String getResource(){
        return resource;
    }
}
