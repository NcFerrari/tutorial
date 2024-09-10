import {defineConfig} from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
    server: {
        // host: '10.0.0.6',
        host: true, /*všechny IP adresy v mé síti :) */
        port: 3000
    },
    plugins: [react()],
})
