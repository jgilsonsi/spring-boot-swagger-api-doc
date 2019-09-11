# spring-boot-swagger-api-doc

Demo project to show the use of the Swagger SpringFox lib and the API doc auto generation process

Swagger-Core Annotations - Quick Annotation Overview
| Name                | Description                                                                |
| ------------------- |:--------------------------------------------------------------------------:|
| @Api                | Marks a class as a Swagger resource.                                       |
| @ApiImplicitParam   | Represents a single parameter in an API Operation.                         |
| @ApiImplicitParams  | A wrapper to allow a list of multiple ApiImplicitParam objects.            |
| @ApiModel           | Provides additional information about Swagger models.                      |
| @ApiModelProperty   | Adds and manipulates data of a model property.                             |
| @ApiOperation       | Describes an operation or typically a HTTP method against a specific path. |
| @ApiParam           | Adds additional meta-data for operation parameters.                        |
| @ApiResponse        | Describes a possible response of an operation.                             |
| @ApiResponses       | A wrapper to allow a list of multiple ApiResponse objects.                 |
| @Authorization      | Declares an authorization scheme to be used on a resource or an operation. |
| @AuthorizationScope | Describes an OAuth2 authorization scope.                                   |

You can find more information about swagger-core [here](https://github.com/swagger-api/swagger-core/wiki/annotations).


**To generate the API doc file in the doc path, run this application in test mode.**