import List from "../components/body/board/List";
import Header from "../components/header/Header";
import Footer from "../components/footer/Footer";


export default function ({posts,setPosts}) {

  return (
    <>
      <Header></Header>
      <List posts={posts} setPosts = {setPosts}></List>
      <Footer></Footer>
    </>
  )
}