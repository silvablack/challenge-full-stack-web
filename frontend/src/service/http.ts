import axios from 'axios'
import { baseApiUrlWsBackend } from '@/config'

export const httpBackend = axios.create({
  baseURL: baseApiUrlWsBackend,
  timeout: 180000
})