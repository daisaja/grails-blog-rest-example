import grails.rest.render.hal.HalJsonCollectionRenderer;
import grails.rest.render.hal.HalJsonRenderer
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
	
	halCollectionBookRenderer(HalJsonCollectionRenderer, Post)
	halBookRenderer(HalJsonRenderer, Post)
}
