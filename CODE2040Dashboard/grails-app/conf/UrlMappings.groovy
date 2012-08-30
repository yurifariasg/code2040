class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		"/"(view: '/index') // This may change when we have our own index page
		"500"(view:'/error')
		
		"/login/$action"(controller: "login")
		"/logout/$action"(controller: "logout")
	}
}
