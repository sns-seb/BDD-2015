package org.sonar.bdd.gatlingmysq

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AdminChecksOutCeQueue extends Simulation {

	val httpProtocol = http
		.baseURL(System.getProperty("targetHost"))
		.inferHtmlResources()

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "image/webp,image/*,*/*;q=0.8",
		"Pragma" -> "no-cache")

	val headers_2 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Pragma" -> "no-cache")

	val headers_3 = Map("Pragma" -> "no-cache")

	val headers_8 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Pragma" -> "no-cache",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_10 = Map("Accept" -> "image/webp,image/*,*/*;q=0.8")

	val headers_11 = Map("X-Requested-With" -> "XMLHttpRequest")

	val headers_12 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_15 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate",
		"Origin" -> "System.getProperty("targetHost")",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_18 = Map("accept" -> "application/json,*/*")

	val headers_24 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"X-Requested-With" -> "XMLHttpRequest")

    val uri1 = "System.getProperty("targetHost")"

	val scn = scenario("AdminChecksOutCeQueue")
		.exec(
			http("SQ Home").get("/").headers(headers_0)
			.resources(
				http("loading icon").get(uri1 + "/images/loading-small.gif")headers(headers_1),
				http("sonar.css").get(uri1 + "/css/sonar.css?v=5.2-M57_2015-10-06").headers(headers_2),
				http("sonar.js").get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06").headers(headers_3),
				http("font").get(uri1 + "/fonts/Roboto-Regular-webfont.woff").headers(headers_3),
            	http("font").get(uri1 + "/fonts/sonar-5.2.woff?").headers(headers_3),
				http("font").get(uri1 + "/fonts/Roboto-Light-webfont.woff").headers(headers_3),
				http("nav/app.js").get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06").headers(headers_3),
				http("l10n").get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000").headers(headers_8).check(status.is(304)),
				http("favicon").get(uri1 + "/images/favicon.ico?1434375344").headers(headers_3),
				http("logo").get(uri1 + "/images/logo.svg").headers(headers_10),
				http("/api/navigation/global").get(uri1 + "/api/navigation/global").headers(headers_11)))
		.pause(3)
		.exec(
			http("Go to login page").get("/sessions/new?return_to=%2F").headers(headers_12)
			.resources(
				http("sonar.js").get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06"),
				http("font").get(uri1 + "/fonts/Roboto-Medium-webfont.woff").headers(headers_3))
			)
		.pause(6)
		.exec(
			http("Login as admin").post("/sessions/login").headers(headers_15)
			.formParam("return_to_anchor", "")
			.formParam("login", System.getProperty("sonar.username"))
			.formParam("password", System.getProperty("sonar.password"))
			.formParam("remember_me", "1")
			.formParam("commit", "")
			.resources(
				http("loading icon").get(uri1 + "/images/loading-small.gif").headers(headers_10),
				http("sonar.js").get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06"),
				http("/measures/search_filter").get(uri1 + "/measures/search_filter?filter=49&metrics=ncloc&fields=name,longName,qualifier&pageSize=40&page=1&sort=metric:ncloc&asc=false").headers(headers_18),
				http("/measures/search_filter").get(uri1 + "/measures/search_filter?filter=54&metrics=coverage,ncloc&fields=name,longName,qualifier&pageSize=100&page=1&sort=metric:ncloc&asc=false").headers(headers_18),
				http("font").get(uri1 + "/fonts/Roboto-Bold-webfont.woff").headers(headers_3),
				http("/measures/search_filter").get(uri1 + "/measures/search_filter?filter=32&metrics=ncloc,violations,line_coverage&fields=name,qualifier&pageSize=20&page=1&sort=metric:ncloc&asc=false").headers(headers_18),
				http("/measures/search_filter").get(uri1 + "/measures/search_filter?filter=38&metrics=coverage,ncloc&fields=name,longName,qualifier&pageSize=100&page=1&sort=metric:ncloc&asc=false").headers(headers_18),
				http("nav/app.js").get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06"),
				http("l10n").get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000").headers(headers_24).check(status.is(304)),
				http("/api/navigation/global").get(uri1 + "/api/navigation/global").headers(headers_11))
			)
		.pause(4)
		.exec(
			http("go to Settings page").get("/settings").headers(headers_12)
			.resources(
				http("loading icon").get(uri1 + "/images/loading.gif").headers(headers_10),
				http("nav/app.js").get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06"),
				http("l10n").get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000").headers(headers_24).check(status.is(304)),
				http("/api/navigation/settings").get(uri1 + "/api/navigation/settings").headers(headers_11),
				http("/api/navigation/global").get(uri1 + "/api/navigation/global").headers(headers_11))
			)
		.pause(4)
		.exec(
			http("Go to Background tasks page").get("/background_tasks").headers(headers_12)
			.resources(
				http("sonar.js").get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06"),
				http("background-tasks/app.js").get(uri1 + "/js/apps/background-tasks/app.js?v=5.2-M57_2015-10-06"),
				http("l10n").get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000").headers(headers_24).check(status.is(304)),
				http("/api/ce/queue").get(uri1 + "/api/ce/queue").headers(headers_11),
				http("/api/ce/activity").get(uri1 + "/api/ce/activity?p=1&ps=200").headers(headers_11),
				http("/api/ce/activity?FAILED").get(uri1 + "/api/ce/activity?ps=1&onlyCurrents=true&status=FAILED").headers(headers_11),
				http("nav/app.js").get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06"),
				http("l10n").get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000").headers(headers_24).check(status.is(304)),
				http("/api/navigation/settings").get(uri1 + "/api/navigation/settings").headers(headers_11),
				http("/api/navigation/global").get(uri1 + "/api/navigation/global").headers(headers_11))
			)
		.pause(5)
		.exec(
			http("Reload background tasks page").get("/api/ce/queue").headers(headers_11)
			.resources(
				http("/api/ce/activity?FAILED").get(uri1 + "/api/ce/activity?ps=1&onlyCurrents=true&status=FAILED").headers(headers_11),
				http("/api/ce/activity").get(uri1 + "/api/ce/activity?p=1&ps=200").headers(headers_11))
			)

	setUp(
		scn.inject(
			atOnceUsers(1)
		)
	).protocols(httpProtocol)
}
