describe("Activity 4 - Network Testing Practice", () => {
  beforeEach(() => {
    // Intercept GET Todos and return fixture
    cy.intercept("GET", "/api/todos", {
      fixture: "todos.json",
    }).as("getTodos");

    cy.visit("http://localhost:3000");

    // Wait until mocked todos load
    cy.wait("@getTodos");
  });

  it("loads todos from fixture correctly", () => {
    cy.get('[data-cy="todo-item"]').should("have.length", 2);

    cy.get('[data-cy="todo-item"]')
      .eq(0)
      .should("contain", "Learn Cypress");

    cy.get('[data-cy="todo-item"]')
      .eq(1)
      .should("contain", "Write Network Tests");
  });

  it("intercepts POST /api/todos when adding a new todo", () => {
    cy.intercept("POST", "/api/todos").as("addTodo");

    cy.get('[data-cy="todo-input"]').type("New Cypress Todo{enter}");

    cy.wait("@addTodo").then((interception) => {
      expect(interception.request.body).to.have.property(
        "text",
        "New Cypress Todo"
      );
    });
  });

  it("shows error message when POST /api/todos fails", () => {
    cy.intercept("POST", "/api/todos", {
      statusCode: 500,
      body: {
        message: "Internal Server Error",
      },
    }).as("addTodoError");

    cy.get('[data-cy="todo-input"]').type("Failing Todo{enter}");

    cy.wait("@addTodoError");

    cy.get('[data-cy="error-message"]')
      .should("be.visible")
      .and("contain", "Error");
  });
});