import { clientURL } from './ApiClient'

export const retrieveHelloWorldBean = (token) => clientURL.get("/hello-world-bean"
// , {
//     headers: {
//         Authorization: token
//     }
// }
)

export const retrieveHelloWorldBeanPathVariable = (username, token) => clientURL.get(`/hello-world-bean/path-variable/${username}`
// ,{
//     headers: {
//         Authorization: token
//     }
// }
)

export const executeBasicAuthenticationService = (token) => clientURL.get(`/basic-auth`
// , {headers: {
//         Authorization: token
//     }}
)