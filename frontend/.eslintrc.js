module.exports = {
  root: true,
  env: {
    node: true,
    browser: true
  },
  extends: [
    'plugin:vue/essential',
    'eslint:recommended',
    '@vue/typescript/recommended',
    'plugin:vue/recommended'
  ],
  parserOptions: {
    ecmaVersion: 2020,
    ecmaFeatures: {
      'legacyDecorators': true
    },
    parser: '@typescript-eslint/parser',
    sourceType: 'module'
  },
  rules: {
    'no-console': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    'no-tabs': ['error', { allowIndentationTabs: true }],
    'vue/html-indent': 'error',
    'vue/script-indent': ['error', 4, { baseIndent: 0 }],
    'object-curly-spacing': ['error', 'always'],
    semi: ['error', 'never'],
    quotes: [2, 'single', { avoidEscape: true }],
    'vue/html-closing-bracket-newline': [
      'error',
      {
        singleline: 'never',
        multiline: 'never'
      }
    ],
    'vue/html-closing-bracket-spacing': [
      'error',
      {
        startTag: 'never',
        endTag: 'never',
        selfClosingTag: 'always'
      }
    ],
    'vue/no-unused-vars': 'error'
  },
  overrides: [
    {
      files: [
        '**/__tests__/*.{j,t}s?(x)',
        '**/tests/unit/**/*.spec.{j,t}s?(x)'
      ],
      env: {
        jest: true
      }
    }
  ]
}
