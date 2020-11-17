// https://docs.cypress.io/api/introduction/api.html

describe('Test e2e in Student page with cypress', () => {

  beforeEach(() => {
    cy.server()
    cy.route({
      method: 'GET',
      url: '/v1/students/',
      response: [
        { registration: 1, name: 'Miguel', cpf: '12312312333', email: 'email@email.com' }
      ]
    })
  })

  it('visit student page and check list of students', () => {
    cy.visit('/')
    cy.contains('h1', 'Alunos')
    cy.contains('[data-cy=submit_register]', 'Cadastrar')
  })
})
