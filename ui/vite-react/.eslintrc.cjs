/**
 * @type {import("eslint").Linter.Config}
 */
module.exports = {
  extends: [
    '@antfu',
  ],
  ignorePatterns: [],
  overrides: [{
    files: ['*.ts', '*.tsx'],
    rules: {
      'no-console': 'warn',
      'n/handle-callback-err': 'warn',
      '@typescript-eslint/ban-ts-comment': 'warn',
      // 'unused-imports/no-unused-vars': 'warn',
    },
  }],
}
