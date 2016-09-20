uglifycss resources/public/css/*.css > resources/public/css/app.css && \
uglifyjs --compress --mangle --output resources/public/js/app.js -- resources/public/js/{functional.min.js,shifty.min.js,main.js,gol.js}
