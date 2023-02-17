import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import css from 'vite-plugin-windicss'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), css()],
  build: {
    manifest: true,
    // ssrManifest: true,
  },
})
