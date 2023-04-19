/** @type {import('tailwindcss').Config} */

module.exports = {
  content: ['./src/**/*.{js,jsx,ts,tsx}'],
  theme: {
    extend: {
      colors: {
        'footer-bg': '#232629',
        'footer-text': '#9199A1',
        'nav-color': '#525960',
        'nav-hover-text': '#232629',
        'nav-hover-bg': '#e3e6e8',
      },
      backgroundImage: {
        sprites: 'url(./assets/img/sprites.svg)',
      },
      backgroundPosition: {
        logo: 'left top -498px',
      },
      boxShadow: {
        'search-focuse': '#dae7f3 0px 5px 15px',
      },
    },
  },
  plugins: [],
};
