ENDPOINT=https://quiet-gorge-11359.herokuapp.com/tcss360/messages
curl -X POST -H "Content-type: application/json" -d '{"userId":3, "message":"swag"}' $ENDPOINT
echo

