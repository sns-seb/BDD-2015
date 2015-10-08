package org.sonar.bdd.gatlingmysq

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class UserChecksOutIssues extends Simulation {

    val uri1 = System.getProperty("targetHost")
    var username = System.getProperty("sonar.username")
    val password = System.getProperty("sonar.password")

	val httpProtocol = http
		.baseURL(uri1)
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

	val headers_14 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate",
		"Origin" -> uri1,
		"Upgrade-Insecure-Requests" -> "1")

	val headers_16 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"X-Requested-With" -> "XMLHttpRequest")

	val scn = scenario("UserChecksOutIssues")
		.exec(
			http("SQ Home").get("/").headers(headers_0)
			.resources(
				http("sonar.css").get(uri1 + "/css/sonar.css?v=5.2-M57_2015-10-06").headers(headers_2),
				http("sonar.js").get(uri1 + "/js/sonar.js?v=5.2-M57_2015-10-06").headers(headers_3),
				http("font").get(uri1 + "/fonts/sonar-5.2.woff?").headers(headers_3),
				http("font").get(uri1 + "/fonts/Roboto-Light-webfont.woff").headers(headers_3),
				http("font").get(uri1 + "/fonts/Roboto-Regular-webfont.woff").headers(headers_3),
				http("nav/app.js").get(uri1 + "/js/apps/nav/app.js?v=5.2-M57_2015-10-06").headers(headers_3),
				http("l10n").get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000").headers(headers_8).check(status.is(304)),
				http("favicon").get(uri1 + "/images/favicon.ico?1434375344").headers(headers_3),
				http("logo.svg").get(uri1 + "/images/logo.svg").headers(headers_10),
				http("/api/navigation/global").get(uri1 + "/api/navigation/global").headers(headers_11)
			)
		)
		.pause(22)
		.exec(
			http("Go to login page").get("/sessions/new?return_to=%2F").headers(headers_12)
			.resources(
				http("font").get(uri1 + "/fonts/Roboto-Medium-webfont.woff").headers(headers_3)
			)
		)
		.pause(8)
		.exec(
			http("Login").post("/sessions/login").headers(headers_14)
			.formParam("return_to_anchor", "")
			.formParam("login", username)
			.formParam("password", password)
			.formParam("remember_me", "1")
			.formParam("commit", "")
			.resources(
				http("issue-filter/widget.js").get(uri1 + "/js/widgets/issue-filter/widget.js?v=5.2-M57_2015-10-06"),
				http("l10n").get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000").headers(headers_16).check(status.is(304)),
				http("l10n").get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000").headers(headers_16).check(status.is(304)),
				http("/api/issues/search").get(uri1 + "/api/issues/search?resolved=false&assignees=__me__&ps=1&facets=severities&facetMode=count").headers(headers_11),
				http("/api/navigation/global").get(uri1 + "/api/navigation/global").headers(headers_11)
			)
		)
		.pause(6)
		.exec(
			http("Go to Issues page").get("/issues/search").headers(headers_12)
			.resources(
				http("l10n").get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000").headers(headers_16).check(status.is(304)),
				http("/api/navigation/global").get(uri1 + "/api/navigation/global").headers(headers_11),
				http("issues/app.js").get(uri1 + "/js/apps/issues/app.js?v=5.2-M57_2015-10-06"),
				http("l10n").get(uri1 + "/api/l10n/index?locale=fr&ts=2015-10-07T15%3A06%3A31%2B0000").headers(headers_16).check(status.is(304)),
				http("/api/issue_filters/app").get(uri1 + "/api/issue_filters/app").headers(headers_11),
				http("/api/issue_filters/search").get(uri1 + "/api/issue_filters/search").headers(headers_16),
				http("/api/issues/search").get(uri1 + "/api/issues/search?p=1&ps=50&s=FILE_LINE&asc=true&additionalFields=_all&facets=severities%2Cresolutions%2Cresolutions%2Cassignees%2Cassigned_to_me&resolved=false&assignees=__me__").headers(headers_11),
				http("select2.png").get(uri1 + "/images/select2.png").headers(headers_10)
			)
		)
		.pause(3)
		.exec(
			http("/api/issues/search").get("/api/issues/search?facets=projectUuids&ps=1&additionalFields=_all&resolved=false&assignees=__me__").headers(headers_11)
		)
		.pause(2)
		.exec(
			http("/api/issues/search").get("/api/issues/search?p=1&ps=50&s=FILE_LINE&asc=true&additionalFields=_all&facets=severities%2Cresolutions%2CprojectUuids%2Cassignees%2Cresolutions%2Cassignees%2CprojectUuids%2Cassigned_to_me&resolved=false&assignees=__me__&projectUuids=69e57151-be0d-4157-adff-c06741d88879").headers(headers_11)
		)
		.pause(2)
		.exec(
			http("/api/issues/search").get("/api/issues/search?p=1&ps=50&s=FILE_LINE&asc=true&additionalFields=_all&facets=severities%2Cresolutions%2CprojectUuids%2Cassignees%2Cresolutions%2Cassignees%2CprojectUuids%2Cassigned_to_me&resolved=false&assignees=__me__&projectUuids=9441c9da-1c21-46df-894b-a6c3a0790daa%2C69e57151-be0d-4157-adff-c06741d88879").headers(headers_11)
		)
		.pause(1)
		.exec(
			http("/api/issues/search").get("/api/issues/search?p=1&ps=50&s=FILE_LINE&asc=true&additionalFields=_all&facets=severities%2Cresolutions%2CprojectUuids%2Cassignees%2Cresolutions%2Cassignees%2CprojectUuids%2Cassigned_to_me&resolved=false&assignees=__me__&projectUuids=9441c9da-1c21-46df-894b-a6c3a0790daa").headers(headers_11)
		)
		.pause(2)
		.exec(
			http("/api/components/app").get("/api/components/app?uuid=4b039a05-029c-46bd-a397-3d01ff4d5ca2").headers(headers_11)
			.resources(
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=4b039a05-029c-46bd-a397-3d01ff4d5ca2&from=1&to=1000").headers(headers_11)
			)
		)
		.pause(1)
		.exec(
			http("/api/components/app").get("/api/components/app?uuid=062d5e64-eab6-47c4-8d6a-8fe65cc60c54").headers(headers_11)
			.resources(
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=062d5e64-eab6-47c4-8d6a-8fe65cc60c54&from=1&to=1000").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/components/app?uuid=2561b1fb-d36d-4205-8cc1-f7dbf7dac67d").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=2561b1fb-d36d-4205-8cc1-f7dbf7dac67d&from=1&to=1000").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/components/app?uuid=5e520fe1-3364-48a4-9221-258f78c87af8").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=5e520fe1-3364-48a4-9221-258f78c87af8&from=1&to=1000").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/components/app?uuid=6ce8c630-75d7-4f42-96d2-6069028d026a").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=6ce8c630-75d7-4f42-96d2-6069028d026a&from=1&to=1000").headers(headers_11)
			)
		)
		.pause(2)
		.exec(
			http("/api/components/app").get("/api/components/app?uuid=AU-xsXslPKA6li6auU4e").headers(headers_11)
			.resources(
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=AU-xsXslPKA6li6auU4e&from=1&to=1000").headers(headers_11)
			)
		).
		pause(1).
		exec(
			http("/api/components/app").get("/api/components/app?uuid=AU-xsXslPKA6li6auU4f").headers(headers_11)
			.resources(
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=AU-xsXslPKA6li6auU4f&from=1&to=1000").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=AVAkarig77-mnICnk2PH").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=AVAkarig77-mnICnk2PH&from=1&to=1000").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=74fd8b52-4cac-40a0-8969-55cc98ce0104").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=74fd8b52-4cac-40a0-8969-55cc98ce0104&from=1&to=1000").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=AVAkarih77-mnICnk2PL").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=AVAkarih77-mnICnk2PL&from=1&to=1000").headers(headers_11)
			)
		)
		.pause(1)
		.exec(
			http("/api/components/app").get("/api/components/app?uuid=AVAkarii77-mnICnk2PO").headers(headers_11)
			.resources(
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=AVAkarii77-mnICnk2PO&from=1&to=1000").headers(headers_11)
			)
		)
		.pause(1)
		.exec(
			http("/api/components/app").get("/api/components/app?uuid=AVAkarii77-mnICnk2PQ").headers(headers_11)
			.resources(
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=AVAkarii77-mnICnk2PQ&from=1&to=1000").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=b943d21e-ae4d-4dee-bb31-db44bf5c0980").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=b943d21e-ae4d-4dee-bb31-db44bf5c0980&from=1&to=1000").headers(headers_11)
			)
		)
		.pause(11)
		.exec(
			http("/api/components/app").get("/api/components/app?uuid=70eacc2f-829e-49f5-bb65-a8eb4f0fee1c").headers(headers_11)
			.resources(
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=70eacc2f-829e-49f5-bb65-a8eb4f0fee1c&from=1&to=1000").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=195aba21-cc3c-4f6c-930c-a891751bfb07").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=195aba21-cc3c-4f6c-930c-a891751bfb07&from=1&to=1000").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=b2d89089-1ef5-498a-af94-6ebc1bcbc452").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=b2d89089-1ef5-498a-af94-6ebc1bcbc452&from=1&to=1000").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=b3528387-0a48-4815-b11e-36d34683ffa9").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=b3528387-0a48-4815-b11e-36d34683ffa9&from=1&to=1000").headers(headers_11),
				http("/api/issues/search").get(uri1 + "/api/issues/search?p=2&ps=50&s=FILE_LINE&asc=true&additionalFields=_all&facets=severities%2Cresolutions%2CprojectUuids%2Cassignees%2Cresolutions%2Cassignees%2CprojectUuids%2Cassigned_to_me&resolved=false&assignees=__me__&projectUuids=9441c9da-1c21-46df-894b-a6c3a0790daa").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=303fc8b2-c745-4f11-a7e8-a7d81a34d619").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=303fc8b2-c745-4f11-a7e8-a7d81a34d619&from=1&to=1000").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=7b65770d-d00b-43c8-856c-aaef1d4beb5b").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=7b65770d-d00b-43c8-856c-aaef1d4beb5b&from=1&to=1000").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=1e3e0708-91df-4233-bcbf-9281728b70ce").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=1e3e0708-91df-4233-bcbf-9281728b70ce&from=1&to=1000").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=91b7bb02-ad35-403c-8c97-1ceb03eb4c13").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=91b7bb02-ad35-403c-8c97-1ceb03eb4c13&from=1&to=1000").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=6ac0ffc0-b312-4604-8908-0393b4fc6936").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=6ac0ffc0-b312-4604-8908-0393b4fc6936&from=1&to=1000").headers(headers_11),
				http("/api/components/app").get(uri1 + "/api/components/app?uuid=71671a15-3916-4d43-bb4e-72bf46a596fe").headers(headers_11),
				http("/api/sources/lines").get(uri1 + "/api/sources/lines?uuid=71671a15-3916-4d43-bb4e-72bf46a596fe&from=1&to=1000").headers(headers_11),
				http("/api/issues/search").get(uri1 + "/api/issues/search?p=3&ps=50&s=FILE_LINE&asc=true&additionalFields=_all&facets=severities%2Cresolutions%2CprojectUuids%2Cassignees%2Cresolutions%2Cassignees%2CprojectUuids%2Cassigned_to_me&resolved=false&assignees=__me__&projectUuids=9441c9da-1c21-46df-894b-a6c3a0790daa").headers(headers_11)
			)
		)



	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
