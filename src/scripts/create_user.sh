ENDPOINT=https://glacial-anchorage-84282.herokuapp.com/tcss360/messages
curl -X POST -H "Content-type: application/json" -d '{"userid":3, "message":"swag"}' $ENDPOINT
echo

