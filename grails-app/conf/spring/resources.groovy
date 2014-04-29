import grails.rest.render.json.JsonCollectionRenderer
import grails.rest.render.json.JsonRenderer
import blog.Post

// Place your Spring DSL code here
beans = {
	postCollectionRenderer(JsonCollectionRenderer, Post) {
		excludes = ['class']
	}
	
	postRenderer(JsonRenderer, Post) {
		excludes = ['class']
	}
}
