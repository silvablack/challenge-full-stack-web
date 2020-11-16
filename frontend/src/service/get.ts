import { get } from 'lodash'

export const getData = (obj: object) => get(obj, 'data')

export const getError = (dataError: any) => {
  let error
  if (dataError && dataError.response && dataError.response.data) {
    const resp = dataError.response.data
      error = {
        status: dataError.response.status,
        description: resp.message || resp.mensagem || resp['error_description']
      }
    return Promise.reject(error)
  } else if (typeof dataError === 'string') {
    error = dataError
    return Promise.reject(error)
  }
  error = 'Unexpected error'
  return Promise.reject(error)
}
