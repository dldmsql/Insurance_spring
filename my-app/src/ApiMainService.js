import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:8080/api/main";

class ApiMainService{
    fetchUsers(){
        return axios.get(USER_API_BASE_URL);
    }
    fetchUserByID(userID){
        return axios.get(USER_API_BASE_URL+'/'+userID);
    }
    deleteUser(userID){
        return axios.delete(USER_API_BASE_URL + '/' + userID);
    }
    addUser(user){
        return axios.post(USER_API_BASE_URL + '/signup' , user);
    }
    editUser(user){
        return axios.put(USER_API_BASE_URL+'/'+ user.id, user);
    }
    login(login){
        return axios.post(USER_API_BASE_URL + '/login', login);
    }

}
export default new ApiMainService();