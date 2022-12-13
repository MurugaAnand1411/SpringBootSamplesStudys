import http from "../http-common";

  class AuditService {
    login(data){
      return http.post("/user/signIn",data);
    }
    register(data){
      return http.post("/user/signUp",data);
    }
    updateuser(id,data){
      return http.post(`/user/update?id=${id}`,data);
    } 
  }

export default new AuditService() ;