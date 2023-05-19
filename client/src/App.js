import Layout from './layout/Layout';
import routes from './routes';
import { useRoutes } from 'react-router-dom';
import withRouter from './hoc/withRouter';

const App = () => {
    const elements = useRoutes(routes);
    return (
        <div className='App'>
            <Layout>{elements}</Layout>
        </div>
    );
};

const AppWithRoutes = withRouter(App);
export default AppWithRoutes;
