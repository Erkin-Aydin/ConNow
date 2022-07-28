import React, {useState, useEffect} from "react";
import ReactDOM from "react-dom/client";
import axios from "axios";

function Post() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [postList, setPostList] = useState([]);

    useEffect(() => {

        axios.get('http://localhost:8080/posts/list')
            .then(function (response) {
                setPostList(response.data);
                setIsLoaded(true);
            })
            .catch(function (error) {
                // handle error
                console.log(error);
                /*
                setIsLoaded(true);
                setError(error);
                 */
            })

    }, [])

    if(error) {
        return <div>Error !!!</div>;
    }
    else if(!isLoaded) {
        return <div>Loading...</div>;
    }
    else {
        return(
          <ul>
              {postList.map(post => (
                  <li key={post.id}>
                      {post.title} {post.text}
                  </li>
              ))}
          </ul>
        );
    }
}

export default Post;
