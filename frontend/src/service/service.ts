/**
 * @type {Service}
 */
export default class Service {
  private options: object;
  /**
   * @param {*} options
   */
  constructor (options: object) {
    this.options = options
  }

  /**
   * @param {*} options
   */
  static build (options: object) {
    return new this(options)
  }
}
