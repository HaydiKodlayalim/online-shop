import axios from "axios";


export function get(path = '') {
    return axios.get(path).catch(err => {
        console.log(err);
        throw new Error('Http Get Error : api.service');
    })
}

export function post(path = '', params) {
    return axios.post(path, params).catch(err => {
        console.log(err);
        throw new Error('Http Post Error : api.service');
    })
}
