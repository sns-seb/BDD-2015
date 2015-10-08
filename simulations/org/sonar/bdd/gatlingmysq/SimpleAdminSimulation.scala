package org.sonar.bdd.gatlingmysq

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SimpleAdminSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("https://sonardesktop:10443")
		.inferHtmlResources()

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Pragma" -> "no-cache")

	val headers_2 = Map(
		"Accept" -> "image/webp,image/*,*/*;q=0.8",
		"Pragma" -> "no-cache")

	val headers_3 = Map("Pragma" -> "no-cache")

	val headers_8 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Pragma" -> "no-cache",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_10 = Map(
		"Pragma" -> "no-cache",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_18 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate",
		"Origin" -> "https://sonardesktop:10443",
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_26 = Map(
		"Pragma" -> "no-cache",
		"accept" -> "application/json,*/*")

    val uri1 = "https://sonardesktop:10443"

	val scn = scenario("SimpleAdminSimulation")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri1 + "/css/sonar.css?v=5.2-M57_2015-10-06")
			.headers(headers_1),
            http("request_2")
			.get(uri1 + "/images/loading-small.gif")
			.headers(headers_2),
            http("request_3")
			.get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06")
			.headers(headers_3),
            http("request_4")
			.get(uri1 + "/fonts/sonar-5.2.woff?")
			.headers(headers_3),
            http("request_5")
			.get(uri1 + "/fonts/Roboto-Light-webfont.woff")
			.headers(headers_3),
            http("request_6")
			.get(uri1 + "/fonts/Roboto-Regular-webfont.woff")
			.headers(headers_3),
            http("request_7")
			.get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06")
			.headers(headers_3),
            http("request_8")
			.get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T14%3A33%3A02%2B0000")
			.headers(headers_8)
			.check(status.is(304)),
            http("request_9")
			.get(uri1 + "/images/logo.svg")
			.headers(headers_2),
            http("request_10")
			.get(uri1 + "/api/navigation/global")
			.headers(headers_10)))
		.pause(6)
		.exec(http("request_11")
			.get("/sessions/new?return_to=%2F")
			.headers(headers_0)
			.resources(http("request_12")
			.get(uri1 + "/images/logo.svg")
			.headers(headers_2),
            http("request_13")
			.get(uri1 + "/css/sonar.css?v=5.2-M57_2015-10-06")
			.headers(headers_1),
            http("request_14")
			.get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06")
			.headers(headers_3),
            http("request_15")
			.get(uri1 + "/fonts/Roboto-Light-webfont.woff")
			.headers(headers_3),
            http("request_16")
			.get(uri1 + "/fonts/Roboto-Regular-webfont.woff")
			.headers(headers_3),
            http("request_17")
			.get(uri1 + "/fonts/Roboto-Medium-webfont.woff")
			.headers(headers_3)))
		.pause(4)
		.exec(http("request_18")
			.post("/sessions/login")
			.headers(headers_18)
			.formParam("return_to_anchor", "")
			.formParam("login", "admin")
			.formParam("password", "admin")
			.formParam("remember_me", "1")
			.formParam("commit", "")
			.resources(http("request_19")
			.get(uri1 + "/images/loading-small.gif")
			.headers(headers_2),
            http("request_20")
			.get(uri1 + "/css/sonar.css?v=5.2-M57_2015-10-06")
			.headers(headers_1),
            http("request_21")
			.get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06")
			.headers(headers_3),
            http("request_22")
			.get(uri1 + "/fonts/Roboto-Regular-webfont.woff")
			.headers(headers_3),
            http("request_23")
			.get(uri1 + "/fonts/Roboto-Light-webfont.woff")
			.headers(headers_3),
            http("request_24")
			.get(uri1 + "/fonts/sonar-5.2.woff?")
			.headers(headers_3),
            http("request_25")
			.get(uri1 + "/fonts/Roboto-Medium-webfont.woff")
			.headers(headers_3),
            http("request_26")
			.get(uri1 + "/measures/search_filter?filter=54&metrics=coverage,ncloc&fields=name,longName,qualifier&pageSize=100&page=1&sort=metric:ncloc&asc=false")
			.headers(headers_26),
            http("request_27")
			.get(uri1 + "/measures/search_filter?filter=49&metrics=ncloc&fields=name,longName,qualifier&pageSize=40&page=1&sort=metric:ncloc&asc=false")
			.headers(headers_26),
            http("request_28")
			.get(uri1 + "/measures/search_filter?filter=32&metrics=ncloc,violations,line_coverage&fields=name,qualifier&pageSize=20&page=1&sort=metric:ncloc&asc=false")
			.headers(headers_26),
            http("request_29")
			.get(uri1 + "/fonts/Roboto-Bold-webfont.woff")
			.headers(headers_3),
            http("request_30")
			.get(uri1 + "/measures/search_filter?filter=38&metrics=coverage,ncloc&fields=name,longName,qualifier&pageSize=100&page=1&sort=metric:ncloc&asc=false")
			.headers(headers_26),
            http("request_31")
			.get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06")
			.headers(headers_3),
            http("request_32")
			.get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T14%3A33%3A02%2B0000")
			.headers(headers_8)
			.check(status.is(304)),
            http("request_33")
			.get(uri1 + "/images/logo.svg")
			.headers(headers_2),
            http("request_34")
			.get(uri1 + "/api/navigation/global")
			.headers(headers_10)))
		.pause(23)
		.exec(http("request_35")
			.get("/settings")
			.headers(headers_0)
			.resources(http("request_36")
			.get(uri1 + "/images/loading.gif")
			.headers(headers_2),
            http("request_37")
			.get(uri1 + "/css/sonar.css?v=5.2-M57_2015-10-06")
			.headers(headers_1),
            http("request_38")
			.get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06")
			.headers(headers_3),
            http("request_39")
			.get(uri1 + "/fonts/Roboto-Regular-webfont.woff")
			.headers(headers_3),
            http("request_40")
			.get(uri1 + "/fonts/Roboto-Light-webfont.woff")
			.headers(headers_3),
            http("request_41")
			.get(uri1 + "/fonts/Roboto-Bold-webfont.woff")
			.headers(headers_3),
            http("request_42")
			.get(uri1 + "/fonts/Roboto-Medium-webfont.woff")
			.headers(headers_3),
            http("request_43")
			.get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06")
			.headers(headers_3)))
		.pause(28)
		.exec(http("request_44")
			.get("/settings")
			.headers(headers_0)
			.resources(http("request_45")
			.get(uri1 + "/images/loading.gif")
			.headers(headers_2),
            http("request_46")
			.get(uri1 + "/css/sonar.css?v=5.2-M57_2015-10-06")
			.headers(headers_1),
            http("request_47")
			.get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06")
			.headers(headers_3),
            http("request_48")
			.get(uri1 + "/fonts/Roboto-Light-webfont.woff")
			.headers(headers_3),
            http("request_49")
			.get(uri1 + "/fonts/Roboto-Bold-webfont.woff")
			.headers(headers_3),
            http("request_50")
			.get(uri1 + "/fonts/Roboto-Medium-webfont.woff")
			.headers(headers_3),
            http("request_51")
			.get(uri1 + "/fonts/Roboto-Regular-webfont.woff")
			.headers(headers_3),
            http("request_52")
			.get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06")
			.headers(headers_3),
            http("request_53")
			.get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T14%3A33%3A02%2B0000")
			.headers(headers_8)
			.check(status.is(304)),
            http("request_54")
			.get(uri1 + "/images/logo.svg")
			.headers(headers_2),
            http("request_55")
			.get(uri1 + "/api/navigation/settings")
			.headers(headers_10),
            http("request_56")
			.get(uri1 + "/api/navigation/global")
			.headers(headers_10),
            http("request_57")
			.get(uri1 + "/fonts/sonar-5.2.woff?")
			.headers(headers_3)))
		.pause(3)
		.exec(http("request_58")
			.get("/background_tasks")
			.headers(headers_0)
			.resources(http("request_59")
			.get(uri1 + "/css/sonar.css?v=5.2-M57_2015-10-06")
			.headers(headers_1),
            http("request_60")
			.get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06")
			.headers(headers_3),
            http("request_61")
			.get(uri1 + "/fonts/Roboto-Regular-webfont.woff")
			.headers(headers_3),
            http("request_62")
			.get(uri1 + "/js/apps/background-tasks/app.js?v=5.2-M57_2015-10-06")
			.headers(headers_3),
            http("request_63")
			.get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06")
			.headers(headers_3)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}