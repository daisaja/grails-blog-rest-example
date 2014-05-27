package blog
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import static org.junit.Assert.*
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient
import spock.lang.Specification

class CorsSupportSpec extends Specification {
	String postResourceUri = 'http://localhost:8080/grails-blog-rest-example/'
	RESTClient http = new RESTClient(postResourceUri)

	def response
	
	def "Posts resource delivers result with 2 entries when called with method GET."() {
		when: response = http.get(path: 'posts', contentType: JSON)
		then: response.data.size() == 2
		and: response.data*.id
	}
	
	def "CORS support is enabled when the blog resource is called."() {
		when: response = http.options(path: 'posts/1', contentType: JSON, headers: [Origin: 'localhost'])
		then:
		response.headers.'Access-Control-Allow-Origin' == 'localhost'
		response.headers.'Access-Control-Allow-Credentials' == 'true'
		response.headers.'Access-Control-Allow-Headers' == 'origin, authorization, accept, content-type, x-requested-with'
		response.headers.'Access-Control-Allow-Methods' == 'GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS'
		response.headers.'Access-Control-Max-Age' == '3600'
	}
}
