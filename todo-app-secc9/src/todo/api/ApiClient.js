import axios from 'axios'

export const clientURL = axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
)