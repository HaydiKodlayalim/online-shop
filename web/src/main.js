import {createApp} from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import VueAxios from "vue-axios";
import axios from 'axios'
import {BASE_URL} from "@/common/config";

axios.defaults.baseURL = BASE_URL;
createApp(App).use(VueAxios, axios).mount('#app')
