package blog
import static org.junit.Assert.*
import groovyx.net.http.HTTPBuilder
import spock.lang.Specification
import static groovyx.net.http.ContentType.*

class CorsSupportSpec extends Specification {
	def postResourceUri = 'http://localhost:8080/grails-blog-rest-example/'
	def http = new HTTPBuilder(postResourceUri)
	
	def "Posts resource delivers result with 2 entries when called with method GET."() {
		when: def html = http.get(path: 'posts', contentType: JSON)
		then: html.HEAD.size() == 2
		and: html.BODY.size() == 2
	}
	
	def "CORS support is enabled when the blog resource is called."() {
		when: 
		def result = http.get( path: 'posts', contentType: JSON) { resp, reader ->
			println "response status: ${resp.statusLine}"
			println 'Headers: -----------'
			resp.headers.each { h ->
			  println " ${h.name} : ${h.value}"
			}
			println 'Response data: -----'
			System.out << reader
			println '\n--------------------'
			reader
		  }
		then: result.BODY
	}
}
