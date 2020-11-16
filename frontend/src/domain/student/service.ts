import Api from '@/service/api'

export class StudentService extends Api {
    /**
     * @param {*} options
     */
    constructor(options: object) {
        super(options, '/api/v1/student')
    }
}
