module.exports = {
	publicPath: process.env.NODE_ENV === 'development' ? '/thesismanagement': './',
	devServer:{
		proxy:{
			'/api':{
				target:'http://localhost:8080/server_war_exploded/',
				changeOrigin:true,
				pathRewrite:{
					'^/api':'/'
				}
			}
		}
	}
}