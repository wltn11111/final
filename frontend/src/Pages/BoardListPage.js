import List from "../Components/Body/Board/List";
import Header from "../Components/Header/Header";
import Footer from "../Components/Footer/Footer";


export default function ({posts}) {

return (
  <>
  <Header></Header>
  <List posts={posts}></List>
  <Footer></Footer>
  </>

)

}