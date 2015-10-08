package org.sonar.bdd.gatlingmysq

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SimpleAdminSimulation2 extends Simulation {

	val httpProtocol = http
		.baseURL("https://sonardesktop:10443")
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
		"Origin" -> "https://sonardesktop:10443",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_18 = Map("accept" -> "application/json,*/*")

	val headers_24 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"X-Requested-With" -> "XMLHttpRequest")

    val uri1 = "https://sonardesktop:10443"

	val scn = scenario("SimpleAdminSimulation2")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri1 + "/images/loading-small.gif")
			.headers(headers_1),
            http("request_2")
			.get(uri1 + "/css/sonar.css?v=5.2-M57_2015-10-06")
			.headers(headers_2),
            http("request_3")
			.get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06")
			.headers(headers_3),
            http("request_4")
			.get(uri1 + "/fonts/Roboto-Regular-webfont.woff")
			.headers(headers_3),
            http("request_5")
			.get(uri1 + "/fonts/sonar-5.2.woff?")
			.headers(headers_3),
            http("request_6")
			.get(uri1 + "/fonts/Roboto-Light-webfont.woff")
			.headers(headers_3),
            http("request_7")
			.get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06")
			.headers(headers_3),
            http("request_8")
			.get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000")
			.headers(headers_8)
			.check(status.is(304)),
            http("request_9")
			.get(uri1 + "/images/favicon.ico?1434375344")
			.headers(headers_3),
            http("request_10")
			.get(uri1 + "/images/logo.svg")
			.headers(headers_10),
            http("request_11")
			.get(uri1 + "/api/navigation/global")
			.headers(headers_11)))
		.pause(3)
		.exec(http("request_12")
			.get("/sessions/new?return_to=%2F")
			.headers(headers_12)
			.resources(http("request_13")
			.get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06"),
            http("request_14")
			.get(uri1 + "/fonts/Roboto-Medium-webfont.woff")
			.headers(headers_3)))
		.pause(6)
		.exec(http("request_15")
			.post("/sessions/login")
			.headers(headers_15)
			.formParam("return_to_anchor", "")
			.formParam("login", "admin")
			.formParam("password", "admin")
			.formParam("remember_me", "1")
			.formParam("commit", "")
			.resources(http("request_16")
			.get(uri1 + "/images/loading-small.gif")
			.headers(headers_10),
            http("request_17")
			.get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06"),
            http("request_18")
			.get(uri1 + "/measures/search_filter?filter=49&metrics=ncloc&fields=name,longName,qualifier&pageSize=40&page=1&sort=metric:ncloc&asc=false")
			.headers(headers_18),
            http("request_19")
			.get(uri1 + "/measures/search_filter?filter=54&metrics=coverage,ncloc&fields=name,longName,qualifier&pageSize=100&page=1&sort=metric:ncloc&asc=false")
			.headers(headers_18),
            http("request_20")
			.get(uri1 + "/fonts/Roboto-Bold-webfont.woff")
			.headers(headers_3),
            http("request_21")
			.get(uri1 + "/measures/search_filter?filter=32&metrics=ncloc,violations,line_coverage&fields=name,qualifier&pageSize=20&page=1&sort=metric:ncloc&asc=false")
			.headers(headers_18),
            http("request_22")
			.get(uri1 + "/measures/search_filter?filter=38&metrics=coverage,ncloc&fields=name,longName,qualifier&pageSize=100&page=1&sort=metric:ncloc&asc=false")
			.headers(headers_18),
            http("request_23")
			.get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06"),
            http("request_24")
			.get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000")
			.headers(headers_24)
			.check(status.is(304)),
            http("request_25")
			.get(uri1 + "/api/navigation/global")
			.headers(headers_11)))
		.pause(4)
		.exec(http("request_26")
			.get("/settings")
			.headers(headers_12)
			.resources(http("request_27")
			.get(uri1 + "/images/loading.gif")
			.headers(headers_10),
            http("request_28")
			.get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06"),
            http("request_29")
			.get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000")
			.headers(headers_24)
			.check(status.is(304)),
            http("request_30")
			.get(uri1 + "/api/navigation/settings")
			.headers(headers_11),
            http("request_31")
			.get(uri1 + "/api/navigation/global")
			.headers(headers_11)))
		.pause(4)
		.exec(http("request_32")
			.get("/background_tasks")
			.headers(headers_12)
			.resources(http("request_33")
			.get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06"),
            http("request_34")
			.get(uri1 + "/js/apps/background-tasks/app.js?v=5.2-M57_2015-10-06"),
            http("request_35")
			.get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000")
			.headers(headers_24)
			.check(status.is(304)),
            http("request_36")
			.get(uri1 + "/api/ce/queue")
			.headers(headers_11),
            http("request_37")
			.get(uri1 + "/api/ce/activity?p=1&ps=200")
			.headers(headers_11),
            http("request_38")
			.get(uri1 + "/api/ce/activity?ps=1&onlyCurrents=true&status=FAILED")
			.headers(headers_11),
            http("request_39")
			.get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06"),
            http("request_40")
			.get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000")
			.headers(headers_24)
			.check(status.is(304)),
            http("request_41")
			.get(uri1 + "/api/navigation/settings")
			.headers(headers_11),
            http("request_42")
			.get(uri1 + "/api/navigation/global")
			.headers(headers_11)))
		.pause(9)
		.exec(http("request_43")
			.get("/api/ce/activity?ps=1&onlyCurrents=true&status=FAILED")
			.headers(headers_11)
			.resources(http("request_44")
			.get(uri1 + "/api/ce/activity?onlyCurrents=true&p=1&ps=200")
			.headers(headers_11)))
		.pause(5)
		.exec(http("request_45")
			.get("/api/ce/queue")
			.headers(headers_11)
			.resources(http("request_46")
			.get(uri1 + "/api/ce/activity?ps=1&onlyCurrents=true&status=FAILED")
			.headers(headers_11),
            http("request_47")
			.get(uri1 + "/api/ce/activity?p=1&ps=200")
			.headers(headers_11)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}