let currentLang = 'en';
let translations = {};

function loadLanguage(lang) {
  fetch(`${lang}.json`)
    .then(res => res.json())
    .then(data => {
      translations = data;
      updateTexts();
    });
}

function updateTexts() {
  document.querySelectorAll('[data-i18n]').forEach(elem => {
    const key = elem.getAttribute('data-i18n');
    const translation = translations[key];

    if (translation) {
      // Footer ke liye innerHTML use karo (because of &copy;)
      if (elem.tagName === 'FOOTER') {
        elem.innerHTML = translation;
      } else if (['H1','H2','H3','P','A','SPAN','BUTTON','LABEL'].includes(elem.tagName)) {
        elem.textContent = translation;
      }
    }
  });
}




document.getElementById("language-selector").addEventListener("change", e => {
  currentLang = e.target.value;
  loadLanguage(currentLang);
});

// Load default language
loadLanguage(currentLang);

const CACHE_NAME = 'kalampragti-cache-v1';
const urlsToCache = [
  '/',
  '/index.html',
  '/script.js',
  '/en.json',
  '/hi.json',
  // Add other files you want to cache
];

self.addEventListener('install', event => {
  event.waitUntil(
    caches.open(CACHE_NAME)
      .then(cache => cache.addAll(urlsToCache))
  );
});

self.addEventListener('fetch', event => {
  event.respondWith(
    caches.match(event.request)
      .then(response => response || fetch(event.request))
  );
});

if ('serviceWorker' in navigator) {
  window.addEventListener('load', function() {
    navigator.serviceWorker.register('service-worker.js');
  });
}
