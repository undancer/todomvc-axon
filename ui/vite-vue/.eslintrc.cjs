/**
 * @type {import("eslint").Linter.Config}
 */
module.exports = {
  extends: [
    '@antfu',
  ],
  ignorePatterns: [],
  overrides: [{
    files: ['*.ts'],
    rules: {
      'no-console': 'warn',
      // 'unused-imports/no-unused-vars': 'warn',
    },
  }],
}
