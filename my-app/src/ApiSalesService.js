import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:8080/api/sale";

class ApiSalesService{
    fetchUsers(){
        return axios.get(USER_API_BASE_URL + '/customer');
    }
    fetchUserByID(userID){
        return axios.get(USER_API_BASE_URL+'/customer/'+userID);
    }
    deleteUser(userID){
        return axios.delete(USER_API_BASE_URL + '/' + userID);
    }
    addUser(user){
        return axios.post(USER_API_BASE_URL + '/customer' , user);
    }
    editUser(user){
        return axios.put(USER_API_BASE_URL+'/'+ user.id, user);
    }

}
export default new ApiSalesService();