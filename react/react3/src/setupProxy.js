const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(
    '/spring', // /api/* 경로로 데이터를 주고 받음
    createProxyMiddleware({
      target: 'http://localhost:8080/spring3',	//스프링 포트
      changeOrigin: true,
    })
  );
};