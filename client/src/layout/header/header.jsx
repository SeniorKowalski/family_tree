import { Link } from 'react-router-dom';

import styles from './header.module.scss';

const Header = () => {
    return (
        <div className={styles.header}>
            <img src='/tree.svg' alt='tree' width={50} />
            <nav>
                <ul>
                    <li>
                        <Link to='/'>Дерево</Link>
                    </li>
                    <li>
                        <Link to='/about'>О проекте</Link>
                    </li>
                </ul>
            </nav>
        </div>
    );
};

export default Header;
