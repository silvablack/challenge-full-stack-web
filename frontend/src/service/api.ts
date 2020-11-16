import Service from '@/service/service'
import { httpBackend } from './http'
import { getData, getError } from './get'

/**
 * @type {Api}
 */
export default class Api extends Service {
  private resource: string;
  /**
   * @param {Object} options
   * @param {string} resource
   */
  constructor (options: object, resource: string) {
    super(options)
    this.resource = resource
  }

  /**
   * @return Array all
   */
  all () {
    return httpBackend(this.resource)
      .then(getData)
      .catch(getError)
  }

  /**
   * @param {Object} record
   */
  create (record: object) {
    return httpBackend.post(this.resource, record)
      .then(getData)
      .catch(getError)
  }

  /**
   * @param {Number} id
   */
  read (id: number) {
    return httpBackend.get(this.resource + '/' + id)
      .then(getData)
      .catch(getError)
  }

  /**
   * @param {Object} record
   */
  update (record: object) {
    return httpBackend.put(this.resource, record)
      .then(getData)
      .catch(getError)
  }

  /**
   * @param {Number} id
   */
  destroy (id: number) {
    return httpBackend.delete(this.resource + '?id=' + id)
      .then(getData)
      .catch(getError)
  }
}
